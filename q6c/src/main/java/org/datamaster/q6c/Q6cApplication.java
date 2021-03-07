package org.datamaster.q6c;

import lombok.extern.slf4j.Slf4j;
import org.datamaster.q6c.service.TitleBasicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Q6cApplication implements CommandLineRunner {

	@Autowired
	private TitleBasicsService titleBasicsService;

	public static void main(String[] args) {
		SpringApplication.run(Q6cApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		titleBasicsService.getEpisodeRatingsByTitle("Breaking Bad")
				.forEach(e -> log.info("Primary Title : {} ---- " +
								"Number of Votes : {} ---- Season Number : {} ---- " +
								"Episode Number : {} ", e.getPrimaryTitle(), e.getVotesNumber(),
						e.getSeasonNumber(), e.getEpisodeNumber()));

	}


}
