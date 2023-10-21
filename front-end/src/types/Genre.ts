import { Playlist } from './Playlist';

export type Genre = {
  id?: number;
  name: string;
  description: string;
  Playlists: Playlist[];
};
