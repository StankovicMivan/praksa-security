package com.praksa.ivan.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.praksa.ivan.model.Igrac;
import com.praksa.ivan.web.dto.IgracDTO;

@Component
public class IgracToIgracDTO implements Converter<Igrac, IgracDTO>{

	public IgracDTO convert(Igrac igrac) {
	
		IgracDTO dto = new IgracDTO();
		
		dto.setId(igrac.getId());
		dto.setIme(igrac.getIme());
		dto.setKlubId(igrac.getKlub().getId());
		dto.setKlubNaziv(igrac.getKlub().getNaziv());
		dto.setPozicija(igrac.getPozicija());
		dto.setPrezime(igrac.getPrezime());
		
		return dto;
	}
	
	public List<IgracDTO> convert(List<Igrac> igraci){
		List<IgracDTO> retVal = new ArrayList<IgracDTO>();
		
		for(Igrac it: igraci) {
			retVal.add(convert(it));
		}
		return retVal;
	}

}
