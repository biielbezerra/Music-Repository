import music.Album
import music.Artista
import music.Musica
import music.Listagem
import kotlin.random.Random

class Gravadora {

    var lista: Listagem = Listagem()
    var objectArtista: Artista = Artista()
    var objectAlbum: Album = Album()
    var objectMusica: Musica = Musica()

    fun cadastrarArtista(nome: String, nacionalidade: String, foto: String, descricao: String): Artista {
        var artista: Artista = Artista()

        val geradorDeNumerosRandomicos = Random(4645)

        artista.foto = foto
        artista.idArtista = geradorDeNumerosRandomicos.nextInt()
        artista.nome = nome
        artista.nacionalidade = nacionalidade
        artista.descricao = descricao
        lista.artistasMutableList.add(artista)
        return artista
    }

    fun criaMusica(
        artistaID: Int,
        nome: String,
        link: String,
        duracao: String,
        produtor: String,
        descricao: String,
        albumID: Int
    ): Musica {
        val musica: Musica = Musica()
        val geradorDeNumerosRandomicos = Random(4645)

        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == albumID }
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        musica.artista = idFinderArtista
        musica.descricao = descricao
        musica.duracao = duracao
        musica.produtor = produtor
        musica.album = idFinderAlbum
        musica.nome = nome
        musica.link = link
        musica.idMusica = geradorDeNumerosRandomicos.nextInt()

        lista.musicasMutableList.add(musica)
        return musica
    }

    fun criarAlbum(
        nome: String,
        link: String,
        genero: String,
        duracao: String,
        produtor: String,
        descricao: String,
        capa: String,
        artistaID: Int
    ): Album {
        val album: Album = Album()
        val geradorDeNumerosRandomicos = Random(4645)

        val idFinder: Artista? = lista.artistasMutableList.find { it.idArtista == artistaID }

        album.artista = idFinder
        album.link = link
        album.nome = nome
        album.genero = genero
        album.duracao = duracao
        album.produtor = produtor
        album.descricao = descricao
        album.capa = capa

        album.idAlbum = geradorDeNumerosRandomicos.nextInt()

        lista.albunsMutableList.add(album)
        return album
    }

    fun editArtista(
        nome: String,
        artistaID: Int,
        nacionalidade: String,
        descricao: String,
        foto: String,
        link: String
    ) {
        objectArtista.edit(nome, link, artistaID, nacionalidade, descricao, foto, lista)
    }

    fun editAlbum(
        nome: String,
        link: String,
        editID: Int,
        objectID: Int,
        genero: String,
        descricao: String,
        compositores: String,
        duracao: String,
        produtor: String,
        capa: String
    ) {
        objectAlbum.editar(
            nome,
            link,
            editID,
            objectID,
            genero,
            descricao,
            compositores,
            lista,
            duracao,
            produtor,
            capa
        )
    }

    fun editMusica(
        nome: String,
        link: String,
        editID: Int,
        objectID: Int,
        genero: String,
        descricao: String,
        compositores: String,
        duracao: String,
        produtor: String,
        capa: String
    ) {
        objectMusica.editar(
            nome,
            link,
            editID,
            objectID,
            genero,
            descricao,
            compositores,
            lista,
            duracao,
            produtor,
            capa
        )
    }

    fun deleteArtista(objectID: Int) {
        val idFinderArtista: Artista? = lista.artistasMutableList.find { it.idArtista == objectID }
        lista.artistasMutableList.remove(idFinderArtista)
    }

    fun deleteAlbum(objectID: Int) {
        val idFinderAlbum: Album? = lista.albunsMutableList.find { it.idAlbum == objectID }
        lista.albunsMutableList.remove(idFinderAlbum)
    }

    fun deleteMusica(objectID: Int) {
        val idFinderMusica: Musica? = lista.musicasMutableList.find { it.idMusica == objectID }
        lista.musicasMutableList.remove(idFinderMusica)
    }
}