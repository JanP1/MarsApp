import { Component, ChangeDetectionStrategy, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { NgApexchartsModule } from 'ng-apexcharts';
import { WeatherService } from '../main-screen/services/weather.service';
import { Weather } from './models/weather.model';
import {
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexYAxis,
  ApexDataLabels,
  ApexPlotOptions,
  ApexLegend,
  ApexTheme
} from 'ng-apexcharts';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  yaxis: ApexYAxis;
  plotOptions: ApexPlotOptions;
  dataLabels: ApexDataLabels;
  legend: ApexLegend;
  theme: ApexTheme;
};

@Component({
  selector: 'app-weather-screen',
  standalone: true,
  imports: [NgApexchartsModule],
  templateUrl: './weather-screen.html',
  styleUrl: './weather-screen.scss',
  changeDetection: ChangeDetectionStrategy.Eager,
})
export class WeatherScreen implements OnInit {
  private weatherService = inject(WeatherService);
  private cdr = inject(ChangeDetectorRef);

  public chartOptions!: Partial<ChartOptions>;
  public isLoading = true;
  public isChartReady = false;

  ngOnInit(): void {
    this.weatherService.getLastSevenWeather().subscribe({
      next: (data: Weather[]) => {
        if (!data || data.length === 0) {
          this.isLoading = false;
          this.cdr.detectChanges();
          return;
        }

        const sortedData = [...data].sort((a, b) => a.sol - b.sol);

        this.chartOptions = {
          series: [
            { name: 'High Temp', data: sortedData.map(d => d.high), color: '#ff4560' },
            { name: 'Low Temp', data: sortedData.map(d => d.low), color: '#008ffb' }
          ],
          chart: {
            type: 'bar',
            height: '100%',
            background: '#171717',
            toolbar: { show: false }
          },
          theme: {
            mode: 'dark'
          },
          plotOptions: {
            bar: {
              horizontal: false,
              columnWidth: '60%'
            }
          },
          dataLabels: {
            enabled: false
          },
          xaxis: {
            categories: sortedData.map(d => `Sol ${d.sol}`),
            labels: { style: { colors: '#ffffff' } }
          },
          yaxis: {
            labels: { style: { colors: '#ffffff' } }
          },
          legend: {
            labels: { colors: '#ffffff' }
          }
        };

        this.isLoading = false;
        this.isChartReady = true;

        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Failed to load weather data', err);
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }
}
