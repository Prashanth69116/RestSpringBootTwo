package com.RestFul.capgemini.demo.MapStruct;

import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.dto.PriceDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T20:01:15+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public PriceDto priceToPriceDto(Integer id) {
        if ( id == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        return priceDto;
    }

    @Override
    public PriceDto priceToPriceDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setPriceId( price.getPriceId() );
        priceDto.setPrice( price.getPrice() );

        return priceDto;
    }

    @Override
    public Price priceDtoToPrice(PriceDto price) {
        if ( price == null ) {
            return null;
        }

        Price price1 = new Price();

        price1.setPriceId( price.getPriceId() );
        price1.setPrice( price.getPrice() );

        return price1;
    }

    @Override
    public List<PriceDto> priceToPriceDtoList(List<Price> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceDto> list1 = new ArrayList<PriceDto>( list.size() );
        for ( Price price : list ) {
            list1.add( priceToPriceDto( price ) );
        }

        return list1;
    }

    @Override
    public List<PriceDto> priceDtoToPriceList(List<PriceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceDto> list1 = new ArrayList<PriceDto>( list.size() );
        for ( PriceDto priceDto : list ) {
            list1.add( priceDto );
        }

        return list1;
    }
}
