package model;

import common.enums.CommandTypeEnum;
import common.enums.PeriodicalEnum;

import static common.constants.CommonConstant.CLOSE_BRACKET;
import static common.constants.CommonConstant.CLOSE_SQ_BRACKET;
import static common.constants.CommonConstant.OPEN_BRACKET;
import static common.constants.CommonConstant.OPEN_SQ_BRACKET;
import static common.constants.CommonConstant.DEADLINE_BY;
import static common.constants.CommonConstant.SPACE;
import static common.enums.CommandTypeEnum.D;
import static common.utils.DateUtil.dateTimeConverter;

public class Deadline extends Task {
    protected String by;

    public Deadline(PeriodicalEnum periodical, String description, String by) {
        super(periodical, description);
        this.by = dateTimeConverter(by);
    }

    @Override
    public void setTime(String by) {
        this.by = dateTimeConverter(by);
    }

    @Override
    public CommandTypeEnum getType() {
        return D;
    }

    @Override
    public String getTime() {
        return by;
    }

    @Override
    public String toString() {
        return OPEN_SQ_BRACKET + D + CLOSE_SQ_BRACKET + super.toString() +
                SPACE + OPEN_BRACKET + DEADLINE_BY + by + CLOSE_BRACKET;
    }
}