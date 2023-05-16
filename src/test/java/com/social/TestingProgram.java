package com.social;



import com.social.model.Inpatient;
import com.social.repository.ImpatientRepository;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    @Rollback(false)
    public class TestingProgram{

        @Autowired
        private ImpatientRepository repo;

        @Test
        public void Addnew(){
            Inpatient patient= new Inpatient();
            patient.setId(5000);
            patient.setFirstname("Sysy");
            patient.setLastname("Sylvie");
            patient.setProvince("Kicukiro");
            patient.setGuardianname("Mom");
            patient.setDistrict("Kicukiro");
            patient.setSocialcase("NONe");

            Inpatient savePatient= repo.save(patient);
            Assertions.assertThat(savePatient).isNotNull();
            Assertions.assertThat(savePatient.getId()).isGreaterThan( 0);

        }
        @Test()
        public void testListAll(){
            Iterable<Inpatient> inpatients= repo.findAll();
            Assertions.assertThat(inpatients).hasSizeGreaterThan(0);
            for(Inpatient patient: inpatients){
                System.out.println(patient);
            }
        }
        @Test
        public void testUpdate(){
            Integer patientId=2;
            Optional<Inpatient>optionalInpatient=repo.findById(patientId);
            Inpatient patient=optionalInpatient.get();
            patient.setGuardianphone("000");
            repo.save(patient);
            Inpatient updatedInpatient=repo.findById(patientId).get();
            Assertions.assertThat(updatedInpatient.getGuardianphone()).isEqualTo("000");

        }


        @Test
        public void testDelete(){
            Integer id=2;
            repo.deleteById(id);
            Optional<Inpatient> optionalInpatient= repo.findById(id);
            Assertions.assertThat(optionalInpatient).isNotPresent();
        }
        @Test
          public  void  testGet(){

            Integer id=6;
            Optional<Inpatient> optionalInpatient=repo.findById(id);
            Assertions.assertThat(optionalInpatient).isPresent();
            System.out.println(optionalInpatient.get());

        }



    }

