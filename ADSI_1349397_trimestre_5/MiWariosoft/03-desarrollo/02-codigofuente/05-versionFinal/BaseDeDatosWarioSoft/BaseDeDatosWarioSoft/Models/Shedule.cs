using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Shedule
    {
        [Key]

        public int IdShedule { get; set; }
        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Observaciones")]
        public string Observaciones{ get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Hora de inicio")]
        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:HH:mm}")]
        public DateTime StartHour { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Hora final")]
        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:HH:mm}")]
        public DateTime endHour { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [Display(Name = "Fecha inicial")]
        public DateTime InitialDate { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [Display(Name = "Fecha final")]
        public DateTime EndDate { get; set; }

        [Display(Name = "Lu")]
        public bool Monday { get; set; }

        [Display(Name = "Ma")]
        public bool Tuesday { get; set; }

        [Display(Name = "Mi")]
        public bool Wednesday { get; set; }

        [Display(Name = "Ju")]
        public bool Thursday { get; set; }

        [Display(Name = "Vi")]
        public bool Friday { get; set; }

        [Display(Name = "Sa")]
        public bool Saturday { get; set; }

        [Display(Name = "Do")]
        public bool Sunday { get; set; }


        public int UserID { get; set; }
        public int IdEnvironment { get; set; }
        public int IdHeadquarters { get; set; }
        public int IdGroup { get; set; }
        public int IdModality { get; set; }

        public virtual Group Group { get; set; }
        public virtual User User { get; set; }
        public virtual Environment Environment { get; set; }
        public virtual Headquarters Headquarters { get; set; }
        public virtual Modality Modality { get; set; }
    }
}