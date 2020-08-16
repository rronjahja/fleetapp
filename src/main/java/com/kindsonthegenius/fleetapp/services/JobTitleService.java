package com.kindsonthegenius.fleetapp.services;

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;
    //return list of countries
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    //save new jobTitle
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }
    //get by id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
