import tkinter
from tkinter import ttk
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

        subprocess_analyze = subprocess.Popen("java -jar " + JAR_LOCATION + " showAnalyses",
                                              shell=True, stdout=subprocess.PIPE)
        allAnalyses = subprocess_analyze.stdout.read().decode()
        vals = allAnalyses.split("\n")
        self.varGr = tkinter.StringVar()
        self.varGr.set(vals[0])
        self.rb = []
        self.analysesList = tkinter.Listbox(self.choixduprogframe)

        for i in range(len(vals)):
            self.analysesList.insert(i, vals[i])

        """
        for i in range(len(vals):
            b = tkinter.Radiobutton(self.choixduprogframe, variable=self.varGr, text=etiqs[i], value=vals[i])
            self.rb.append(b)
        """

        self.startbtn = tkinter.Button(self.choixduprogframe, text="Analyser !", command=self.analyse, state="disabled")

        # Affichage des widget
        self.panel.pack(fill="both", expand=1, pady=10)
        self.mainframe.pack(expand=1, fill="both", padx=10, pady=10)
        self.choixduprogframe.pack(expand=1, fill="both", pady=10, padx=10)
        self.label1.pack()
        self.btnBrowse.pack(fill="x", pady=10, padx=10)
        self.label2.pack()
        """
        for radiobtn in self.rb:
            radiobtn.pack()
        """
        self.analysesList.pack()
        self.analysesList.select_set(0)
        self.analysesList.event_generate("<<ListboxSelect>>")

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
        )
        if(self.progname):
            self.btnBrowse['text'] = self.progname.name
            self.progname = self.progname.name
            self.startbtn['state'] = 'normal'

    def openWindow(self, title, size = None):
        newWindow = tkinter.Toplevel(self.app)
        newWindow.title(title)
        container = ttk.Frame(newWindow)
        container.grid_propagate(False)
        if size:
            canvas = tkinter.Canvas(container, width=size[0], height=size[1])
        else:
            canvas = tkinter.Canvas(container)

        scrollbar = ttk.Scrollbar(container, orient="vertical", command=canvas.yview)
        scrollable_frame = ttk.Frame(canvas)

        scrollable_frame.bind(
            "<Configure>",
            lambda e: canvas.configure(
                scrollregion=canvas.bbox("all")
            )
        )

        canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")

        canvas.configure(yscrollcommand=scrollbar.set)
        container.pack(fill="both", expand=True)
        canvas.pack(side="left", fill="both", expand=True)
        scrollbar.pack(side="right", fill="both", expand=True)
        return canvas

    def analyse(self):
        subprocess_analyze = subprocess.Popen("java -jar " + JAR_LOCATION + " " + self.progname + " " + str(self.analysesList.curselection()[0]),
                                              shell=True, stdout=subprocess.PIPE)
        analyse = subprocess_analyze.stdout.read()
        # analyseOutText = analyse.decode('utf-8')
        analyseOutText = analyse
        self.analyseOutWindow = self.openWindow("Resultat d'analyse")
        self.analyseOut = tkinter.Text(self.analyseOutWindow, height=len(analyseOutText)/50)
        self.analyseOut.insert("end", analyseOutText)
        self.analyseOut.config(state="disabled")
        self.analyseOut.pack(fill='both', expand=True)
        subprocess_getdotname = subprocess.Popen(
            "java -jar " + JAR_LOCATION + " getDotName " + self.progname, shell=True,
            stdout=subprocess.PIPE)
        dotname = subprocess_getdotname.stdout.read()
        pathtoDot = dotname.decode('utf-8')
        pathtoDot = pathtoDot.replace("\r\n", '')
        os.system("dot -Tpng " + pathtoDot + " > " + pathtoDot.replace(".dot", ".png"))
        self.imgDot = Image.open(pathtoDot.replace(".dot", ".png"))
        self.imgDisplay = ImageTk.PhotoImage(self.imgDot)
        tkinter.Label(self.openWindow("Flow du programme", (self.imgDisplay.width() + 10, self.imgDisplay.height() + 10)), image=self.imgDisplay).pack()


Gui()
