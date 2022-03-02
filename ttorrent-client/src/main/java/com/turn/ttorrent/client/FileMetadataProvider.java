package com.turn.ttorrent.client;

import com.turn.ttorrent.common.AnnounceListener;
import com.turn.ttorrent.common.TorrentMetadata;
import com.turn.ttorrent.common.TorrentParser;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public abstract class FileMetadataProvider implements AnnounceListener, TorrentMetadataProvider {

  private final String filePath;

  public FileMetadataProvider(String filePath) {
    this.filePath = filePath;
  }

  @NotNull
  @Override
  public TorrentMetadata getTorrentMetadata() throws IOException {
    File file = new File(filePath);
    return new TorrentParser() {
      @Override
      public Set<String> getExtAnnounceURLs() {
        return FileMetadataProvider.this.getExtAnnounceURLs();
      }
    }.parseFromFile(file);
  }
}
