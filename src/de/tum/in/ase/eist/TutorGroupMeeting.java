package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public TutorGroup getTutorGroup() {
        return tutorGroup;
    }

    public Skill getSkillToPractice() {
        return skillToPractice;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void practice() {
        Student tutor = getTutorGroup().getTutor();
        tutor.say("Welcome to the physical tutor meeting");
        sayWelcome(tutor);
        tutor.say("We start with the homework presentation");

        List<Student> homeworkPresentationCandidates = new ArrayList<>(getTutorGroup().getStudents());
        present(homeworkPresentationCandidates);

        tutor.say("Next is the group work");
        learnSkill();

        tutor.say("Let's have a look at the new homework");
        sayThankYou(tutor);
        tutor.say("See you next time!");
    }

    public void present(List<Student> homeworkPresentationCandidates) {
        for (int i = 0; i < NUMBER_OF_HOMEWORK_PRESENTATIONS; i++) {
            if (homeworkPresentationCandidates.isEmpty()) {
                break;
            }
            int randomIndex = ThreadLocalRandom.current().nextInt(homeworkPresentationCandidates.size());
            Student randomStudent = homeworkPresentationCandidates.get(randomIndex);
            randomStudent.presentHomework();
            homeworkPresentationCandidates.remove(randomIndex);
        }
    }

    public void learnSkill() {
        Skill skill = getSkillToPractice();
        skill.apply();
        for (Student student : getTutorGroup().getStudents()) {
            student.learnSkill(skill);
        }
    }

    public void sayWelcome(Student tutor) {
        tutor.say("Thank you for coming here today.");
    }

    public void sayThankYou(Student tutor) {
        tutor.say("Thank you that you have participated today.");
    }
}
