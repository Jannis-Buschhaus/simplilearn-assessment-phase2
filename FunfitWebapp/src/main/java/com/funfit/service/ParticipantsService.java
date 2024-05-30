package com.funfit.service;

import java.util.List;

import com.funfit.bean.Participants;
import com.funfit.dao.ParticipantsDao;

public class ParticipantsService {
	public static String addParticipant(Participants p) {
		if(ParticipantsDao.addParticipants(p)>0) {
			return "Participant added successfully.";
		} else {
			return "Participant was not added.";
		}
	}
	public static List<Participants> getParticipants() {
		return ParticipantsDao.getParticipants();
	}
	public static String deleteParticipant (int partId) {
		if(ParticipantsDao.deleteParticipant(partId) > 0) {
			return "Participant "+partId+"deleted successfully";
		} else {
			return "Unable to delete Participant: "+partId;
		}
	}
	
	public static List<Participants> updateParticipant(Participants p) {
		List<Participants> lp = ParticipantsDao.updateParticipants(p);
		if(lp != null) {
			return lp;
		} else {
			return null;
		}
	}
}
