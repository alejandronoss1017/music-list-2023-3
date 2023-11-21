import { Genre } from './Genre';

export type Song = {
  id: number;
  name: string;
  artist: string;
  duration: number | string;
  likes?: number;
  album: string;
  favorite: boolean;
  releaseDate?: string;
  genreId?: number;
  genre: Genre;
};
