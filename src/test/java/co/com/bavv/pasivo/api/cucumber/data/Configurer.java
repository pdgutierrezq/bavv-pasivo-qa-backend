/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.cucumber.data;

import co.com.bavv.pasivo.api.karate.def.KarateStaticResource;
import co.com.bavv.pasivo.api.screenplay.data.AnInfo;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.TableTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Configurer implements TypeRegistryConfigurer {

    public static JacksonTableTransformer jacksonTableTransformer;

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        jacksonTableTransformer = new JacksonTableTransformer();
        registry.setDefaultParameterTransformer(jacksonTableTransformer);
        registry.setDefaultDataTableEntryTransformer(jacksonTableTransformer);
        registry.setDefaultDataTableCellTransformer(jacksonTableTransformer);
        registry.setDefaultDataTableCellTransformer(jacksonTableTransformer);
        registry.defineDataTableType(new DataTableType(Map.class, new TableTransformer<Map>() {
            @Override
            public Map transform(DataTable dataTable) throws Throwable {
                Map<String, String> map = dataTable.asLists().stream()
                    .collect(Collectors.toMap(m -> m.get(0), m -> m.get(1)));
                return map;
            }
        }));
        registry.defineDataTableType(
            new DataTableType(AnInfo.class, new TableTransformer<AnInfo>() {
                @Override
                public AnInfo transform(DataTable dataTable) throws Throwable {
                    Map<String, String> map = dataTable.asLists().stream()
                        .collect(Collectors.toMap(m -> m.get(0), m -> m.get(1)));
                    AnInfo.loaded().setInfo(map);
                    KarateRunner.setRequestBody(AnInfo.loaded().toString());
                    return AnInfo.loaded();
                }
            }));
    }

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    private static final class JacksonTableTransformer implements ParameterByTypeTransformer,
        TableEntryByTypeTransformer, TableCellByTypeTransformer {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Object transform(String s, Type type) {
            Object object;
            if (type == KarateStaticResource.class) {
                object = KarateStaticResource.identifiedBy(s);
            } else {
                object = objectMapper.convertValue(s, objectMapper.constructType(type));
            }
            return object;
        }

        @Override
        public <T> T transform(Map<String, String> entry, Class<T> type,
            TableCellByTypeTransformer cellTransformer) {
            return objectMapper.convertValue(entry, type);
        }

        @Override
        public <T> T transform(String value, Class<T> cellType) {
            return objectMapper.convertValue(value, cellType);
        }
    }

}
