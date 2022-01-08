import tkinter
from PIL import ImageTk, Image
from tkinter import filedialog
import os


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

    def openNewWindow(self, img):
        # Toplevel object which will
        # be treated as a new window
        newWindow = tkinter.Toplevel(self.app)

        # sets the title of the
        # Toplevel widget
        newWindow.title("Graphique du programme")

        # sets the geometry of toplevel

        # A Label widget to show in toplevel
        panelDisplay = tkinter.Label(newWindow, image=img).pack()


    def analyse(self):
        print("java -jar target/Enoso-1.0-SNAPSHOT-jar-with-dependencies.jar " + self.progname)
        # os.system("java -jar target/Enoso-1.0-SNAPSHOT-jar-with-dependencies.jar "+self.progname)
        import subprocess
        subprocess = subprocess.Popen("java -jar target/Enoso-1.0-SNAPSHOT-jar-with-dependencies.jar " + self.progname,
                                      shell=True, stdout=subprocess.PIPE)
        analyse = subprocess.stdout.read()
        import subprocess
        subprocess = subprocess.Popen(
            "java -jar target/Enoso-1.0-SNAPSHOT-jar-with-dependencies.jar getDotName " + self.progname, shell=True,
            stdout=subprocess.PIPE)
        subprocess_return = subprocess.stdout.read()
        print(subprocess_return)
        pathtoDot = subprocess_return.decode('utf-8')
        pathtoDot = pathtoDot.replace("\r\n", '')
        print("dot -Tpng " + pathtoDot + " > " + pathtoDot + ".png")
        os.system("dot -Tpng " + pathtoDot + " > " + pathtoDot + ".png")
        imgDot = Image.open(pathtoDot + ".png")
        imgDisplay = ImageTk.PhotoImage(imgDot)
        self.openNewWindow(imgDisplay)
        tkinter.messagebox.showinfo("Resultat", analyse)


Gui()
