package com.omercnet.graylog2.uaparser;

import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.PluginModule;

import java.util.Collection;
import java.util.Collections;

/**
 * Implement the Plugin interface here.
 */
public class UaParserFunctionPlugin implements Plugin {
    @Override
    public PluginMetaData metadata() {
        return new UaParserFunctionMetaData();
    }

    @Override
    public Collection<PluginModule> modules () {
        return Collections.<PluginModule>singletonList(new UaParserFunctionModule());
    }
}
