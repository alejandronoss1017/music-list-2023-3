import { Pipe, PipeTransform } from '@angular/core';
import { SongService } from '../services/songs/song.service';

@Pipe({
  name: 'formatDuration',
})
export class FormatDurationPipe implements PipeTransform {
  constructor(private songService: SongService) {}

  transform(duration: number | any): string {
    return this.songService.formatDuration(duration);
  }
}
