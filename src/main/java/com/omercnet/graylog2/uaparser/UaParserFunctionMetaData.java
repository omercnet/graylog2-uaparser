package com.omercnet.graylog2.uaparser;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class UaParserFunctionMetaData implements PluginMetaData {
    private static final String PLUGIN_PROPERTIES = "com.omercnet.graylog2.graylog-plugin-function-uaparser/graylog-plugin.properties";

    @Override
    public String getUniqueId() {
        return "com.omercnet.graylog2.uaparser.UaParserFunctionPlugin";
    }

    @Override
    public String getName() {
        return "User-Agent Parser";
    }

    @Override
    public String getAuthor() {
        return "Omer Cohen <git@omerc.net>";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/omercnet/graylog2-uaparser");
    }

    @Override
    public Version getVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "version", Version.from(1, 0, 0));
    }

    @Override
    public String getDescription() {
        return "User-Agent parser pipeline function based on https://github.com/ua-parser/uap-java";
    }

    @Override
    public Version getRequiredVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "graylog.version", Version.from(2, 1, 1));
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
