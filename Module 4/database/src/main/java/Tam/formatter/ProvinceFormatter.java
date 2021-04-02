package Tam.formatter;

import Tam.model.Provinces;
import Tam.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Provinces> {

    private ProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Provinces parse(String text, Locale locale) throws ParseException {
        return provinceService.findById(Long.parseLong(text));
    }



    @Override
    public String print(Provinces object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}