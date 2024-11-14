package msg.ticking.show.domain.model.policy;

public abstract class PolicyCondition {
    private String value;
    public abstract boolean isSatisfied();
}
