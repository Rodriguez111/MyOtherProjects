package ua.com.foxminded.division.maths;

import lombok.*;
import ua.com.foxminded.division.utils.Utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
@Setter
@XmlRootElement(name = "Step")
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    public Step() {
    }

    public Step(int subtrahend, int subtract, int difference) {
        this.subtrahend = subtrahend;
        this.subtract = subtract;
        this.difference = difference;
    }

    public Step(int subtrahend, int subtract, int difference, int offsetOfSubtrahend, int offsetOfSubtract) {
        this.subtrahend = subtrahend;
        this.subtract = subtract;
        this.difference = difference;
        this.offsetOfSubtrahend = offsetOfSubtrahend;
        this.offsetOfSubtract = offsetOfSubtract;
    }

    private int subtrahend;
    private int subtract;
    private int difference;
    private int divider;
    private int globalResult;
    private int offsetOfSubtrahend;
    private int offsetOfSubtract;
    private int remainderOffset;
    private String printStep = "";

    public void setPrintStep(String printStep) {
        this.printStep = this.printStep + printStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Step step = (Step) o;
        return subtrahend == step.subtrahend
                && subtract == step.subtract
                && difference == step.difference
                && divider == step.divider
                && globalResult == step.globalResult
                && offsetOfSubtrahend == step.offsetOfSubtrahend
                && offsetOfSubtract == step.offsetOfSubtract
                && remainderOffset == step.remainderOffset
                && Objects.equals(printStep, step.printStep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtrahend, subtract, difference, divider, globalResult, offsetOfSubtrahend, offsetOfSubtract, remainderOffset, printStep);
    }
}
