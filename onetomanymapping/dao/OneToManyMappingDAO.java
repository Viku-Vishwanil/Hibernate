package edu.jspiders.onetomanymapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.jspiders.onetomanymapping.dto.BatchesDTO;
import edu.jspiders.onetomanymapping.dto.TrainerProfessionalDTO;
import edu.jspiders.singletonfactory.classes.SingletonFactory;

public class OneToManyMappingDAO 
{
	public void createBatch(int trainerId)
	{
		SessionFactory factory = SingletonFactory.getFactory();
		
		Session session = factory.openSession();
		
		TrainerProfessionalDTO trainer = session.get(TrainerProfessionalDTO.class, trainerId);
		
		if(trainer != null)
		{
			BatchesDTO batch1 = new BatchesDTO("HECM33","Core Java");
			BatchesDTO batch2 = new BatchesDTO("HECE22","Core Java");
			BatchesDTO batch3 = new BatchesDTO("HECA13","Core Java");
			
			trainer.addBatches(batch1);
			trainer.addBatches(batch2);
			trainer.addBatches(batch3);
			
			session.save(batch1);
			session.save(batch2);
			session.save(batch3);
			
			session.beginTransaction().commit();
			}
		else
		{
			System.out.println("Not Present");
		}
	}
}
