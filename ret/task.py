

class task:
    def __init__(self, level=0):
        self.name = ''
        self.description = ''
        self.percent = 0
        self.hours = None
        self.level = level
        self.subtasks = []

    def add_subtask(self, oTask):
        if self.subtasks is None:
            self.subtasks = []
        oTask.level = self.level + 1
        self.subtasks.append(oTask)

    def update_hours(self, lHours):
        self.hours = []
        for iHour in lHours:
            self.hours.append((self.percent/100) * iHour)

    def get_all_tasks(self):
        lReturn = []
        lReturn.append(self)
        for oSubtask in self.subtasks:
            lReturn.extend(oSubtask.get_all_tasks())
        return lReturn
