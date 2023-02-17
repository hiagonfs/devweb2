package src.main.java.com.unifip.ads.sp2fy.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import src.main.java.com.unifip.ads.sp2fy.entidades.Musica;

@Service
public class ServicoMusica {

	private List<Musica> musicas;

	public ServicoMusica() {
		this.musicas = new ArrayList<>();
	}

	public List<Musica> recuperaListaDeMusicas() {
		return musicas;
	}

	public Musica cadastraMusica(Musica musica) {
		musicas.add(musica);
		return musica;
	}

	public Musica encontraMusica(String nome) {
		for (Musica musica : musicas) {
			if (musica.getNome().equals(nome)) {
				musicas.remove(musica);
				return musica;
			}
		}
		return null;
	}

	public Musica removeMusica(Musica musicaEncontrada) {
		if (musicas.contains(musicaEncontrada)) {
			musicas.remove(musicaEncontrada);
			return musicaEncontrada;
		}
		return null;
	}

}
