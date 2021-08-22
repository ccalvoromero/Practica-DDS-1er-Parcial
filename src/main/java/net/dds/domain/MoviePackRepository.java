package net.dds.domain;

import net.dds.domain.pack.MoviePack;

public interface MoviePackRepository {
    MoviePack findByGenre(String genre);
}