package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.document.DocumentDTO;
import com.app.FO.model.document.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class DocumentDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "documentId", source = "id")
    public abstract DocumentDTO documentToDocumentDTO(Document topic);

    public abstract List<DocumentDTO> documentListToDocumentDTOList(List<Document> topic);

}
