package src.main.java.com.unifip.ads.sp2fy.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.unifip.ads.sp2fy.entidades.Musica;
import src.main.java.com.unifip.ads.sp2fy.servicos.ServicoMusica;

@RestController
@RequestMapping("/v1/musica")
public class MusicaController {

	@Autowired
	private ServicoMusica servicoMusica;

	@GetMapping("/listaDeMusicas")
	public ResponseEntity<List<Musica>> getListaDeMusica() {
		return new ResponseEntity<List<Musica>>(servicoMusica.recuperaListaDeMusicas(), HttpStatus.OK);
	}

	@PostMapping("/cadastroMusica")
	public ResponseEntity<Musica> cadastraMusica(@RequestBody Musica musica) {
		return new ResponseEntity<Musica>(servicoMusica.cadastraMusica(musica), HttpStatus.CREATED);
	}

	@DeleteMapping("/removeMusica/{nome}")
	@ResponseBody
	public ResponseEntity<Musica> removeMusica(@PathVariable String nome) {
		Musica musicaEncontrada = servicoMusica.encontraMusica(nome);
		if (musicaEncontrada != null) {
			servicoMusica.removeMusica(musicaEncontrada);
			return ResponseEntity.ok(musicaEncontrada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
