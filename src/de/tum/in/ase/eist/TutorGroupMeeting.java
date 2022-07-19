package de.tum.in.ase.eist;

public abstract class TutorGroupMeeting {
    static final int NUMBER_OF_HOMEWORK_PRESENTATIONS = 3;
    protected final TimeSlot timeSlot;
    protected final TutorGroup tutorGroup;
    protected final Skill skillToPractice;

    public TutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice) {
        this.timeSlot = timeSlot;
        this.tutorGroup = tutorGroup;
        this.skillToPractice = skillToPractice;
    }

    public abstract TutorGroup getTutorGroup();

    public abstract Skill getSkillToPractice();

    public abstract TimeSlot getTimeSlot();

    public abstract void practice();
}
