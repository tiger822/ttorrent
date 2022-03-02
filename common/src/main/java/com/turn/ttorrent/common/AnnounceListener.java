package com.turn.ttorrent.common;

import java.util.Set;

/**
 * Created by rocklee on 2022/3/1 21:20
 */
public interface AnnounceListener {
  Set<String> getExtAnnounceURLs();
}
