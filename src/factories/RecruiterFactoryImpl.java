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
        return getRecruiters().getRecruiter();
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
		Recruiters recruiters = getRecruiters();
		recruiters.getRecruiter().add(recruiter);
		setRecruiters(recruiters);
		
	}

	@Override
	public void update(Recruiter recruiter) {
		//**
		
	}

	@Override
	public void delete(String email) {
		Recruiters recruiters = getRecruiters();
		recruiters.getRecruiter().remove(getOne(email));
		setRecruiters(recruiters);
	}

	private Recruiters getRecruiters() {
		try { return JParse.unmarshal(Recruiters.class, FILE);
		} catch (JAXBException e) { e.printStackTrace(); }
		return null;
	}

	private void setRecruiters(Recruiters recruiters) {
		try { JParse.marshal(recruiters, FILE, FILE.getPath());
		} catch (JAXBException e) { e.printStackTrace(); }
	}
}
