using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Disponibility
    {

        [Key]
        public int idDisponibility { get; set; }

        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode =true, DataFormatString ="{0:HH:mm}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Hora de inicio")]
        public String startHour { get; set; }

        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:HH:mm}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Hora final")]
        public String endHour { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Lunes")]
        public Boolean lunes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Martes")]
        public Boolean martes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Miércoles")]
        public Boolean miercoles { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Jueves")]
        public Boolean jueves { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Viernes")]
        public Boolean viernes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Sábado")]
        public Boolean sabado { get; set; }


        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Domingo")]
        public Boolean domingo { get; set; }

        public int instructorID { get; set; }
        public virtual Instructor Instructor { get; set; }

    }
}