package msg.ticking.show.domain.model.policy;

import msg.ticking.show.domain.model.policy.PolicyCondition;

import java.time.DayOfWeek;

public class ConditionFactory {
    public static PolicyCondition createCondition(String type, String value) {
        switch(type) {
            case "DAY":
                return new DayCondition(DayOfWeek.valueOf(value));
            case "TIME":
                return new TimeCondition(value);
            default:
                throw new IllegalArgumentException("Unknown condition type");
        }
    }
}
