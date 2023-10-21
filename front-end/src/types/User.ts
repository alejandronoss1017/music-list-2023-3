import { Song } from "./Song";

export type User = {
  name: string;
  email: string;
  password: string;
  favoriteSongs: Song[];
};
