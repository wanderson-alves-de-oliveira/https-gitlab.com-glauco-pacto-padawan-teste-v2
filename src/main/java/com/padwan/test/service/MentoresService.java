package com.padwan.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padwan.test.dto.MentorDTO;
import com.padwan.test.entity.Mentor;
import com.padwan.test.repositories.MentorRepository;

@Service
public class MentoresService {

    @Autowired
    MentorRepository mentorRepository;
    public void setMentorRepository(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getMentoresComAprendizes() {
        return mentorRepository.findAllMentores();
    }

    
    public void CriarMentor(MentorDTO mentorDTO) {

        Mentor mentor = new Mentor();
        mentor.setNome(mentorDTO.getNome());
        
        mentorRepository.save(mentor);
    }
    
}
