package com.app.FO.repository.remainder;

import com.app.FO.model.note.NoteTag;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemainderRepository extends JpaRepository<Remainder, Long> {


}
