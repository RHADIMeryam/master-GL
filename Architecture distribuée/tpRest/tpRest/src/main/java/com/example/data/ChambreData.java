package com.example.data;

import java.text.SimpleDateFormat;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Chambre;
import com.example.repository.ChambreRepository;



//s'execute la premiere lors du lancement du serveur
@Configuration
public class ChambreData {
	
	private Logger logger = LoggerFactory.getLogger(ChambreData.class);
	SimpleDateFormat formater=new SimpleDateFormat("yyyy-mm-dd");
	
	@Bean
	public CommandLineRunner init(ChambreRepository chambreRepository) {
		
		return args-> {
			//ici on fait .findById; chambreRepository.findAll et aussi ajouter les instances
			logger.info("Preloding : "+chambreRepository.save(new Chambre(2,45.00,formater.parse("2021-11-29"),1,false,"src/main/resources/img1.jpeg")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(1,25.00,formater.parse("2021-30-12"),2,true,"hgyy")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(2,22.00,formater.parse("2021-29-12"),3,false,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(3,50.00,formater.parse("2022-29-01"),4,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(1,30.00,formater.parse("2022-09-01"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(1,35.00,formater.parse("2022-21-01-"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(2,70.00,formater.parse("2021-29-11"),2,false,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(4,150.00,formater.parse("2021-29-12"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(2,30.00,formater.parse("2021-22-12"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(1,15.00,formater.parse("2021-29-11"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(3,60.00,formater.parse("2022-29-05"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(1,30.00,formater.parse("2022-29-12"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(2,340.00,formater.parse("2021-12-11"),2,false,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(3,70.00,formater.parse("2022-19-11"),2,true,"hhhhh")));
			logger.info("Preloding : "+chambreRepository.save(new Chambre(4,380.00,formater.parse("2022-08-08"),2,true,"hhhhh")));
			

		};
		
	}

}