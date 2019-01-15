package io.forge.faas.string.utils.rest;

import com.google.common.base.CaseFormat;
import io.forge.faas.string.utils.dto.SingleValueHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StringFaasUtilsResource {

    @PostMapping("/convert/camelcase")
    public ResponseEntity<List<String>> convertUnderScoreToCamelCase(@RequestBody SingleValueHolder singleValueHolder) {
        String value = singleValueHolder.getValue();
        String[] splitValues = value.split(" ");

        List<String> collect = Arrays.stream(splitValues)
                .map(currentValue -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, currentValue))
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                collect,
                HttpStatus.OK
        );
    }
}
