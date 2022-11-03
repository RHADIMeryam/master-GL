package com.example.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Client;
import com.example.repository.ClientRepository;

@Configuration

public class ClientData {
	private Logger logger = LoggerFactory.getLogger(ClientData.class);
	
 	@Bean
	public CommandLineRunner initDataHotel(ClientRepository clientRepository) {
		
		return args-> {
			 
			//ici on fait .findById; chambreRepository.findAll et aussi ajouter les instances
			logger.info("Preloding data client : "+clientRepository.save(new Client("meryam","rhadi","rtguyi")));
			logger.info("Preloding data client : "+clientRepository.save(new Client("lamyae","khairoune","TYHG676")));


		};

}
}