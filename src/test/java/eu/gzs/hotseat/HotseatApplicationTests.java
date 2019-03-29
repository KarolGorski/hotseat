package eu.gzs.hotseat;

import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.daoclasses.MovieService;
import eu.gzs.hotseat.daoclasses.SeanceService;
import eu.gzs.hotseat.model.Client;
import eu.gzs.hotseat.model.Movie;
import eu.gzs.hotseat.model.Seance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.HttpURLConnection;
import java.net.http.HttpRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotseatApplicationTests {

	@Autowired
	private ClientService clientService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private SeanceService seanceService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldCreateClientWithProperData(){
		//GIVEN
		Client client=new Client("Krzysztof Piatek");

		//WHEN
		clientService.save(client);
		Client client2=clientService.findByClientId(client.getId());

		//THEN
		Assert.assertEquals(client.getName(), client2.getName());
	}

	@Test
	public void shouldCreateMovieWithProperData() {
		//GIVEN
		Movie movie = new Movie("Gladiator", 120);

		//WHEN
		movieService.save(movie);
		Movie savedMovie = movieService.findByMovieId(movie.getId());

		//THEN
		Assert.assertEquals(movie.getName(), savedMovie.getName());
		Assert.assertEquals(movie.getDuration(), savedMovie.getDuration());
	}

	@Test
	public void shouldCreateSeanceWithProperData() {
		//GIVEN
		Movie movie = new Movie("film", 120);
		Movie savedMovie = movieService.save(movie);
		Seance seance = new Seance(movie, 10);

		//WHEN
		seanceService.save(seance);
		Seance savedSeance = seanceService.findBySeanceId(seance.getId());

		//THEN
		Assert.assertEquals(savedMovie.getName(), savedSeance.getMovie().getName());
		Assert.assertEquals(savedMovie.getDuration(), savedSeance.getMovie().getDuration());
		Assert.assertEquals(seance.getSeats().stream().count(), savedSeance.getSeats().stream().count());
	}

	@Test
	public void shouldCreateReservationWithProperData() throws Exception{
		//Http
	}


}
