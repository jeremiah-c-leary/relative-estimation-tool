
import Tkinter as tk

import task

iRowHeight = 0.9

class myApp:
    def __init__(self, myParent):

        self.dColumnWidths = create_column_widths_dictionary()
        lHours = [200, 400, 600, 800]
        headerFrame = tk.Frame(myParent, bg='grey')
        headerFrame.grid(row=0, column=0)
        self.rowFrame = tk.Frame(myParent, bg='tan')
        self.rowFrame.grid(row=1, column=0)
        create_header(headerFrame, self.dColumnWidths, lHours)
        self.oTopLevelTask = task.task()
        self.oTopLevelTask.update_hours(lHours)
        self.oTopLevelTask.percent = 100
        self.oTopLevelTask.name = 'TopLevelTask'
        self.paintRowFrame()


    def paintRowFrame(self):
        print('[Entering] paintRowFrame')
        self.rowFrame.grid_forget()
        self.rowFrame.grid(row=1, column=0)
        lTasks = self.oTopLevelTask.get_all_tasks()
        lHours = self.oTopLevelTask.hours
        for iRowNum, oPaintTask in enumerate(lTasks):
            create_row(self.rowFrame, self.dColumnWidths, oPaintTask, iRowNum)
        print('[Exiting] paintRowFrame')

def callback():
    print('Click!')
    return True

def update_name(oTask, sName):
    oTask.name = sName
    return True

def update_hours():
    print('Updating Hours')
    return True

def update_percent(oTask, iPercent):
    try:
        oTask.percent = int(iPercent)
        return True
    except ValueError:
        return False
    else:
        return False

def update_description(oTask, sDescription):
    oTask.description = sDescription
    return True

def add_subtask_to(oTask):
    oSubTask = task.task()
    oSubTask.update_hours(oTask.hours)
    oTask.add_subtask(oSubTask)
    myApp.paintRowFrame()

def row_color_lookup(iLevelNum):
    if iLevelNum == 0:
        return 'tan'
    if iLevelNum == 1:
        return 'cornflower blue'
    if iLevelNum == 2:
        return 'sea green'
    if iLevelNum == 3:
        return 'coral1'
    return 'white'

def format_row_widget(oWidget, iWidth, justify=tk.LEFT, level=0):
    oWidget['width'] = iWidth
    oWidget['justify'] = justify
    background = row_color_lookup(level)
    oWidget['background'] = row_color_lookup(level)
    oWidget['relief'] = 'flat'
    oWidget['validate'] = 'focusout'

def create_row(myParent, dColumnWidths, oTask, iRowNum):
    print('[Entering] create_row')
    lHours = oTask.hours
    sColor = row_color_lookup(oTask.level)

    tk.Button(myParent, text="+", background=sColor, command=lambda: add_subtask_to(oTask)).grid(row=0+iRowNum, column=0)

    nameEntry = tk.Entry(myParent,
                         validatecommand=lambda: update_name(oTask, nameEntry.get()))
    nameEntry.insert(tk.END, oTask.name)
    format_row_widget(nameEntry, dColumnWidths['task'], tk.LEFT, oTask.level)
    nameEntry.grid(row=0+iRowNum, column=1)

    descriptionEntry = tk.Entry(myParent,
                                validatecommand=lambda: update_description(oTask, descriptionEntry.get()))
    descriptionEntry.insert(tk.END, oTask.description)
    format_row_widget(descriptionEntry, dColumnWidths['description'], tk.LEFT, oTask.level)
    descriptionEntry.grid(row=0+iRowNum, column=2)

    percentEntry = tk.Entry(myParent,
                            validatecommand=lambda: update_percent(oTask, percentEntry.get()))
    percentEntry.insert(tk.END, oTask.percent)
    format_row_widget(percentEntry, dColumnWidths['percent'], tk.CENTER, oTask.level)
    percentEntry.grid(row=0+iRowNum, column=3)

    for iIndex, sHour in enumerate(oTask.hours):
        tk.Label(myParent, text=sHour, width=dColumnWidths['hours'], justify=tk.CENTER, background=row_color_lookup(oTask.level)).grid(row=0+iRowNum, column=4+iIndex)
    print('[Exiting] create_row')

###############################################################################
# Seems to be working
###############################################################################

def create_header(myParent, dColumnWidths, lHours):
    print('[Entering] create_header')
    tk.Label(myParent, text='Task', relief="flat", width=dColumnWidths['task'], justify="left", background="grey", foreground="white").grid(row=0, column=0, rowspan=2)
    tk.Label(myParent, text='Description', relief="flat", width=dColumnWidths['description'], justify=tk.LEFT, background="grey", foreground="white").grid(row=0, column=1, rowspan=2)
    tk.Label(myParent, text='Percent', relief="flat", width=dColumnWidths['percent'], justify=tk.CENTER, background="grey", foreground="white").grid(row=0, column=2, rowspan=2)
    tk.Label(myParent, text='Hours', relief="flat", background="grey", foreground="white").grid(row=0, column=len(lHours), columnspan=4)
    for iIndex, sHour in enumerate(lHours):
        tk.Entry(myParent, width=dColumnWidths['hours'], justify=tk.CENTER, relief="flat", validate="focusout", validatecommand=update_hours).grid(row=1, column=(3 + iIndex))
    print('[Exiting] create_header')

def create_column_widths_dictionary():
    print('[Entering] create_column_widths_dictionary')
    dReturn = {}
    dReturn['task'] = 30
    dReturn['description'] = 50
    dReturn['percent'] = 10
    dReturn['hours'] = 15
    print('[Exiting] create_column_widths_dictionary')

    return dReturn


root = tk.Tk()
myApp = myApp(root)
root.mainloop()

