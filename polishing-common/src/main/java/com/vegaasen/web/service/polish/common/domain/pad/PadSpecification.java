package com.vegaasen.web.service.polish.common.domain.pad;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class PadSpecification {

    private int grade;
    private PadToughness padToughness;

    public PadSpecification(int grade, PadToughness padToughness) {
        this.grade = grade;
        this.padToughness = padToughness;
    }

    public int getGrade() {
        return grade;
    }

    public PadToughness getPadToughness() {
        return padToughness;
    }


}
