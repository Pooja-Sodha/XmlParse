package com.parsexml.cd;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CdServices {
	public List<CdDto> getCdList();
}
