import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by Admin on 4/6/2017.
 */
public class AbstractJsonSqlTypeDescriptor implements SqlTypeDescriptor {

    public int getSqlType() {
        return Types.OTHER;
    }

    public boolean canBeRemapped() {
        return true;
    }

    public <X> ValueBinder<X> getBinder(JavaTypeDescriptor<X> javaTypeDescriptor) {
        return null;
    }

    public <X> ValueExtractor<X> getExtractor(
            final JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicExtractor<X>(javaTypeDescriptor, this) {
            @Override
            protected X doExtract(
                    ResultSet rs,
                    String name,
                    WrapperOptions options) throws SQLException {
                return javaTypeDescriptor.wrap(
                        rs.getObject(name), options
                );
            }

            @Override
            protected X doExtract(
                    CallableStatement statement,
                    int index,
                    WrapperOptions options) throws SQLException {
                return javaTypeDescriptor.wrap(
                        statement.getObject(index), options
                );
            }

            @Override
            protected X doExtract(
                    CallableStatement statement,
                    String name,
                    WrapperOptions options) throws SQLException {
                return javaTypeDescriptor.wrap(
                        statement.getObject(name), options
                );
            }
        };
    }
}
