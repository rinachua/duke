package logic.commands;

import common.exceptions.EmptyTaskListException;
import common.exceptions.InvalidTaskDescriptionException;
import common.exceptions.NotExistTaskException;
import common.exceptions.UnmarkedTaskException;
import model.Chat;
import model.Task;
import ui.ConsoleUi;

import static common.enums.CommandEnum.unmark;
import static common.constants.CommonConstant.INIT_INT_VAL;
import static common.constants.CommonConstant.UNMARKED_TASK;
import static common.utils.StringUtil.getDescriptionFromString;
import static logic.validators.Validator.validateUnmark;

public class UnmarkCommand extends Command {
    public UnmarkCommand(ConsoleUi ui, Chat chat) {
        super(ui, chat);
    }

    /**
     * Return unmarks a task
     *
     * @throws  EmptyTaskListException
     * @throws  InvalidTaskDescriptionException
     * @throws  NotExistTaskException
     * @throws  UnmarkedTaskException
     */
    @Override
    public void execute() throws EmptyTaskListException, InvalidTaskDescriptionException, NotExistTaskException, UnmarkedTaskException {
        String description = getDescriptionFromString(unmark, chat.getInput());
        validateUnmark(description, chat);

        Task task = chat.getTaskList().get(Integer.parseInt(description) - INIT_INT_VAL);
        task.unmarkDone();
        ui.printUpdatedMarkedTask(UNMARKED_TASK, description, task);
    }
}
