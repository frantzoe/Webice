package factories;

import collections.Recruiters;
import models.Recruiter;
import utilities.JParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class RecruiterFactoryImpl implements RecruiterFactory {

    private File FILE;

    public RecruiterFactoryImpl(String path) {
        this.FILE = new File(path);
    }
    
	@Override
	public List<Recruiter> getAll() {
        try { Recruiters recruiters = JParse.unmarshal(Recruiters.class, FILE);
        	return recruiters.getRecruiter();
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
	}

	@Override
	public Recruiter getOne(String email) {
        for (Recruiter recruiter : getAll()) {
            if (recruiter.getEmail().equals(email)) {
                return recruiter;
            }
        }
        return null;
    }

	@Override
	public void create(Recruiter recruiter) {
		//**
		
	}

	@Override
	public void update(Recruiter recruiter) {
		//**
		
	}

	@Override
	public void delete(Recruiter recruiter) {
		//**
		
	}

  
}
