package net.v4lproik.googlanime.platform.dao.api;

import net.v4lproik.googlanime.platform.service.api.entities.Anime;

public interface AnimeDao extends EntryDao{
    Long save(Anime anime);
    Anime findById(Long id);
    Anime find(Anime anime);
    void saveOrUpdate(Anime anime);
    void update(Anime anime);
    void delete(Anime anime);
    void deleteById(Long id);
}
