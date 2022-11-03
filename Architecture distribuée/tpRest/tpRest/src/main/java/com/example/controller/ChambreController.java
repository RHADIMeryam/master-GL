package com.example.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.exceptions.*;
import com.example.model.*;
import com.example.repository.*;

@RestController
//@Produces("application/xml")
// dans cette classe on declare les methodes dont on a besoin dans notre service web
public class ChambreController {

	@Autowired // pour faire injection de dependence
	private ChambreRepository chambreRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private OffreRepository offreRepository;

	// private static final String uri= "http://localhost:8003/serviceweb/api";
	private static final String uriChambre = "/chambre";
	private static final String uriHotel = "/hotel";
	private static final String uriAgence = "/agence";

	@GetMapping(uriChambre + "/getListChambres")
	public List<Chambre> getAllChambre() {
		return chambreRepository.findAll();
	}

	@GetMapping(uriHotel + "/getListHotels")
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@GetMapping(uriAgence + "/getListAgences")
	public List<Agence> getAllAgences() {
		return agenceRepository.findAll();
	}

	@GetMapping(uriChambre + "/{idChambre}")
	public Chambre getChambreById(@PathVariable int idChambre) throws ChambreNotFoundException {
		return chambreRepository.findById(idChambre).orElseThrow(
				() -> new ChambreNotFoundException("Le id que vous avez donner ne correspond à aucune chambre"));
	}

	@GetMapping(uriHotel + "/hotels/{idHotel}")
	public Hotel getHotelById(@PathVariable int idHotel) throws HotelNotFoundException {
		return hotelRepository.findById(idHotel).orElseThrow(
				() -> new HotelNotFoundException("Le id que vous avez donner ne correspond à aucune hotel"));
	}

	@GetMapping(uriChambre + "/offre/{idOffre}")
	public Optional<Offre> getOffreById(@PathVariable int idOffre) {
		return offreRepository.findById(idOffre);
	}

	@GetMapping(uriHotel + "/agences/{idDeAgence}")
	public Hotel getHotelByIdAgence(@PathVariable int idAgence) throws HotelNotFoundException {
		return hotelRepository.findById(idAgence).orElseThrow(
				() -> new HotelNotFoundException("Le id que vous avez donner ne correspond à aucune hotel"));
	}

	@GetMapping(uriAgence + "/agences/{idAgence}")
	public Agence getAgenceById(@PathVariable int idAgence) throws AgenceNotFoundException {
		return agenceRepository.findById(idAgence).orElseThrow(
				() -> new AgenceNotFoundException("Le id que vous avez donner ne correspond à aucune agence"));
	}

	@GetMapping("/rechrcher/{idAgence}/motDepasse/{motDePasse}")
	public Hotel rechercherHotel(@PathVariable int idAgence, @PathVariable String motDePasse,
			@PathVariable int nbrPers) {

		Agence agence = agenceRepository.findById(idAgence).get();
		return null;
	}

	@GetMapping("affichage")
	public void affichage() {
		String sayHello = "hello world";
		System.out.println("<html><body> <span style='color:blue;'> hello world </span></body></html>");
	}

	// relattion chambre hotel
	@PutMapping(uriChambre + "/{idChambre}/hotel/{idHotel}")
	Chambre assignHotelToChambre(@PathVariable int idChambre, @PathVariable int idHotel) {
		Chambre chambre = chambreRepository.findById(idChambre).get();
		Hotel hotel = hotelRepository.findById(idHotel).get();
		chambre.setHotel(hotel);
		return chambreRepository.save(chambre);
	}
	//

	@PutMapping(uriChambre + "/{idReservation}/chambreId/{idChambre}")
	Reservation assignReservationToChambre(@PathVariable int idReservation, @PathVariable int idChambre) {
		Chambre chambre = chambreRepository.findById(idChambre).get();
		Reservation reservation = reservationRepository.findById(idReservation).get();
		reservation.setChambreReserver(chambre);
		return reservationRepository.save(reservation);
	}

	// reservation
	@GetMapping(uriChambre + "/{idOffre}")
	Reservation ajouterReservation(@PathVariable int idOffre) {
		int idChambre = idOffre;
		Chambre chambre = chambreRepository.findById(idChambre).get();
		Reservation reservation = new Reservation();
		List<Reservation> listReserv=new ArrayList<>();
		if (chambre.getEstDispo() == true) {
			// Reservation reservation =
			// reservationRepository.findById(idReservation).get();
			reservation.setChambreReserver(chambre);
			reservation.setDateDebutSejour(chambre.getDateDisponabilite());
			reservation.setNbrLits(chambre.getNbrlits());
			reservation.setNbrPers(chambre.getNbrPers());
			reservation.setPrixTotal(chambre.getPrix() * 3);
			reservation.setDateFinSejour(null);
			reservationRepository.save(reservation);
			listReserv.add(reservation);
			chambre.setListeReservation(listReserv);
			chambreRepository.save(chambre);
		}
		return reservation;
	}

	//

	@PutMapping(uriHotel + "/{idHotel}/agence/{idAgence}")
	public Hotel assignHotelToAgence(@PathVariable int idHotel, @PathVariable int idAgence) {
		Hotel hotel = hotelRepository.findById(idHotel).get();
		Agence agence = agenceRepository.findById(idAgence).get();
		hotel.setAgence(agence);
		return hotelRepository.save(hotel);
	}

	/*
	 * @PutMapping(uriChambre+"/{idChambre}/offre/{idOffre}") public Offre
	 * assignChambreToOffre(
	 * 
	 * @PathVariable int idChambre,
	 * 
	 * @PathVariable int idOffre ){ Chambre
	 * chambre=chambreRepository.findById(idChambre).get(); Offre
	 * offre=offreRepository.findById(idOffre).get(); offre.setChambre(chambre);
	 * return offreRepository.save(offre); }
	 */

	// fonction de recherche
	@GetMapping(uriHotel + "/findAgence/{idAgence}/nbrPers/{nbrPers}")
	public List<Offre> rechercherOffre(@PathVariable int idAgence, @PathVariable int nbrPers) {
		Agence agence = agenceRepository.findById(idAgence).get();
		Offre offre = new Offre();
		List<Offre> listOffresRetourner = new ArrayList<>();
		// List<Chambre> listChambreRetourner = new ArrayList<>();
		for (Hotel hotel : agence.getListHotels()) {
			for (Chambre chambre : hotel.getListChambres()) {
				if (chambre.getNbrPers() == nbrPers) {
					// listChambreRetourner.add(chambre);
					offre.setIdOffre(chambre.getIdChambre());
					offre.setChambre(chambre);
					offre.setIdOffre(chambre.getIdChambre());
					offre.setPrixTotale(chambre.getPrix() * 3);
					offre.setDateDesponabilite(chambre.getDateDisponabilite());
					listOffresRetourner.add(offre);
				}

			}

		}

		return listOffresRetourner;

	}

	// fonction de reservation

}
