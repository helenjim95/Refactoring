package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PhysicalTutorGroupMeeting extends TutorGroupMeeting {

	private final String room;

	public PhysicalTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String room) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.room = room;
	}

	@Override
	public TutorGroup getTutorGroup() {
		return tutorGroup;
	}

	@Override
	public Skill getSkillToPractice() {
		return skillToPractice;
	}

	@Override
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public String getRoom() {
		return room;
	}

	@Override
	public void practice() {
		Student tutor = getTutorGroup().getTutor();
		tutor.say("Welcome to the physical tutor meeting");
		tutor.say("Thank you for coming to " + room + " today.");
		tutor.say("We start with the homework presentation");

		List<Student> homeworkPresentationCandidates = new ArrayList<>(getTutorGroup().getStudents());

		for (int i = 0; i < NUMBER_OF_HOMEWORK_PRESENTATIONS; i++) {
			if (homeworkPresentationCandidates.isEmpty()) {
				break;
			}
			int randomIndex = ThreadLocalRandom.current().nextInt(homeworkPresentationCandidates.size());
			Student randomStudent = homeworkPresentationCandidates.get(randomIndex);
			randomStudent.presentHomework();
			homeworkPresentationCandidates.remove(randomIndex);
		}

		tutor.say("Next is the group work");
		Skill skill = getSkillToPractice();
		skill.apply();
		for (Student student : getTutorGroup().getStudents()) {
			student.learnSkill(skill);
		}

		tutor.say("Let's have a look at the new homework");
		tutor.say("Thank you that you have participated in " + room + " today.");
		tutor.say("See you next time!");
	}
}
