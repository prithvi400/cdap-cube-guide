/*
 * Copyright © 2014 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package co.cask.cdap.benchmarks.metrics;

import co.cask.cdap.test.ApplicationManager;
import co.cask.cdap.test.TestBase;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Test for {@link MetricsBenchmark}.
 */
public class MetricsBenchmarkTest extends TestBase {

  @Test
  public void test() throws TimeoutException, InterruptedException, IOException {
    ApplicationManager app = deployApplication(MetricsBenchmark.class);
    app.startWorker(MetricsBenchmark.MetricsEmitter.NAME);
    app.startService(MetricsBenchmark.BenchmarkService.NAME, ImmutableMap.of("hostname", "localhost"));
  }
}