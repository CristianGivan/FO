package com.app.FO.mapper;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.remainder.RemainderDTO;
import com.app.FO.model.remainder.Remainder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReminderDTOMapper {
    public abstract RemainderDTO RemainderTORemainderDTO (Remainder remainder);
    public abstract List<RemainderDTO> RemainderTORemainderDTO (List<Remainder> remainder);
}
