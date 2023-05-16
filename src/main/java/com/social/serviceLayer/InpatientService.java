package com.social.serviceLayer;

import com.social.model.Inpatient;
import com.social.repository.ImpatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InpatientService {
    @Autowired
    private ImpatientRepository repo;

    public List<Inpatient> listAll() {

        return (List<Inpatient>) repo.findAll();

    }

    public  void save(Inpatient patient){
        repo.save(patient);
    }

    public  Inpatient get(Integer id) throws  UserNotFoundException{

        Optional<Inpatient> result=repo.findById(id);

        if(result.isPresent()){
            return  result.get();
        }
        throw new UserNotFoundException("Couldn't find the patient with" + id);
    }

    public  void delete(Integer id) throws UserNotFoundException{
        Long count= repo.countById(id);
        if(count==null || count==0){
            throw new UserNotFoundException("Couldn't find the teacher with id" +id);
        }
        repo.deleteById(id);
    }

}
