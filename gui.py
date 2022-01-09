import tkinter
from PIL import ImageTk, Image
from tkinter import filedialog
import os
import subprocess

JAR_LOCATION = "target/Enoso-1.0-SNAPSHOT-jar-with-dependencies.jar"


class Gui():
    def __init__(self) -> None:
        self.app = tkinter.Tk()
        self.app.title("Enoso")
        self.progname = ""
        self.app.minsize(211, 538)

        # Creation des widgets
        self.imgFile = Image.open("logo_small.png")
        self.img = ImageTk.PhotoImage(self.imgFile.resize((self.imgFile.height // 6, self.imgFile.width // 6)))
        self.panel = tkinter.Label(self.app, image=self.img)
        self.mainframe = tkinter.LabelFrame(self.app, text="Enoso - Analyse du langage while")

        self.creditframe = tkinter.LabelFrame(self.mainframe, text="Crédit")
        self.creditLabel1 = tkinter.Label(self.creditframe, text="Pierre-Louis Bertrand")
        self.creditLabel2 = tkinter.Label(self.creditframe, text="Ionas Neonakis")
        self.creditLabel3 = tkinter.Label(self.creditframe, text="Thomas Quetier")
        self.creditLabel4 = tkinter.Label(self.creditframe, text="Samir Toulharmine")

        self.choixduprogframe = tkinter.LabelFrame(self.mainframe, text="Analyse")
        self.label1 = tkinter.Label(self.choixduprogframe, text="Choix du programme")
        self.btnBrowse = tkinter.Button(self.choixduprogframe, text='Parcourir', command=self.askopenfile)
        self.label2 = tkinter.Label(self.choixduprogframe, text="Type d'analyse")

        vals = ['VeryBusy', 'Reaching', 'AvailableExp', 'LiveVar']
        etiqs = ['Very Busy', 'Reaching Definition', 'Available Expression', 'Live Variable']
        self.varGr = tkinter.StringVar()
        self.varGr.set(vals[0])
        self.rb = []
        for i in range(4):
            b = tkinter.Radiobutton(self.choixduprogframe, variable=self.varGr, text=etiqs[i], value=vals[i])
            self.rb.append(b)

        self.startbtn = tkinter.Button(self.choixduprogframe, text="Analyser !", command=self.analyse)

        # Affichage des widget
        self.panel.pack(fill="both", expand=1, pady=10)
        self.mainframe.pack(expand=1, fill="both", padx=10, pady=10)
        self.choixduprogframe.pack(expand=1, fill="both", pady=10, padx=10)
        self.label1.pack()
        self.btnBrowse.pack(fill="x", pady=10, padx=10)
        self.label2.pack()
        for radiobtn in self.rb:
            radiobtn.pack()

        self.startbtn.pack(fill="both", pady=10, padx=10)

        self.creditframe.pack(side="bottom", fill="x", pady=10, padx=10)
        self.creditLabel1.pack()
        self.creditLabel2.pack()
        self.creditLabel3.pack()
        self.creditLabel4.pack()

        self.app.mainloop()

    def askopenfile(self):
        self.progname = filedialog.askopenfile(
            title="Select a File",
        ).name
        self.btnBrowse['text'] = self.progname

    def openWindow(self, title):
        newWindow = tkinter.Toplevel(self.app)
        newWindow.title(title)
        canv = tkinter.Canvas(newWindow)
        canv.grid(row=0, column=0)

        defilY = tkinter.Scrollbar(newWindow, orient='vertical',
                           command=canv.yview)
        defilY.grid(row=0, column=1, sticky='ns')

        defilX = tkinter.Scrollbar(newWindow, orient='horizontal',
                           command=canv.xview)
        defilX.grid(row=1, column=0, sticky='ew')

        canv['xscrollcommand'] = defilX.set
        canv['yscrollcommand'] = defilY.set
        return canv

    def analyse(self):
        subprocess_analyze = subprocess.Popen("java -jar " + JAR_LOCATION + " " + self.progname,
                                              shell=True, stdout=subprocess.PIPE)
        analyse = subprocess_analyze.stdout.read()
        tkinter.Label(self.openWindow("Resultat d'analyse"), text=analyse.decode('utf-8')).pack()
        subprocess_getdotname = subprocess.Popen(
            "java -jar " + JAR_LOCATION + " getDotName " + self.progname, shell=True,
            stdout=subprocess.PIPE)
        dotname = subprocess_getdotname.stdout.read()
        pathtoDot = dotname.decode('utf-8')
        pathtoDot = pathtoDot.replace("\r\n", '')
        os.system("dot -Tpng " + pathtoDot + " > " + pathtoDot.replace(".dot", ".png"))
        self.imgDot = Image.open(pathtoDot.replace(".dot", ".png"))
        self.imgDisplay = ImageTk.PhotoImage(self.imgDot)
        tkinter.Label(self.openWindow("Graphique"), image=self.imgDisplay).pack()


Gui()
